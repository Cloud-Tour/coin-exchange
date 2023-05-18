package fun.cloudtour.match;

import fun.cloudtour.model.Order;
import fun.cloudtour.model.OrderBooks;

public interface MatchService {

    /**
     * 执行撮合交易
     * @param orderBooks
     * @param order
     */
    void match(OrderBooks orderBooks,Order order) ;
}

