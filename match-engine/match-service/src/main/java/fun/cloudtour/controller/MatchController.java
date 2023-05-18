package fun.cloudtour.controller;


import com.lmax.disruptor.EventHandler;
import fun.cloudtour.disruptor.OrderEvent;
import fun.cloudtour.disruptor.OrderEventHandler;

import fun.cloudtour.domain.DepthItemVo;
import fun.cloudtour.enums.OrderDirection;
import fun.cloudtour.feign.OrderBooksFeignClient;
import fun.cloudtour.model.MergeOrder;
import fun.cloudtour.model.OrderBooks;
import fun.cloudtour.model.TradePlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class MatchController implements OrderBooksFeignClient {

    @Autowired
    private EventHandler<OrderEvent>[] eventHandlers;


    @GetMapping("/match/order")
    public TreeMap<BigDecimal, MergeOrder> getTradeData(@RequestParam(required = true) String symbol, @RequestParam(required = true) Integer orderDirection) {
        for (EventHandler<OrderEvent> eventHandler : eventHandlers) {
            OrderEventHandler orderEventHandler = (OrderEventHandler) eventHandler;
            if (orderEventHandler.getSymbol().equals(symbol)) {
                OrderBooks orderBooks = orderEventHandler.getOrderBooks();
                return orderBooks.getCurrentLimitPrices(OrderDirection.getOrderDirection(orderDirection));
            }
        }
        return null;
    }


    @Override
    public Map<String, List<DepthItemVo>> getDepth(@RequestParam(required = true) String symbol) {
        Map<String, List<DepthItemVo>> depths = new HashMap<>();
        for (EventHandler<OrderEvent> eventHandler : eventHandlers) {
            OrderEventHandler orderEventHandler = (OrderEventHandler) eventHandler;
            // 找到对应的深度数据
            if (orderEventHandler.getSymbol().equals(symbol)) {
                OrderBooks orderBooks = orderEventHandler.getOrderBooks();
                TradePlate buyTradePlate = orderBooks.getBuyTradePlate();
                TradePlate sellTradePlate = orderBooks.getSellTradePlate();
                depths.put("bids", buyTradePlate.getItems());
                depths.put("asks", sellTradePlate.getItems());
                return depths;
            }
        }
        return null;
    }

}
