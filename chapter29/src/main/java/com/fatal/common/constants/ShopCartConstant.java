package com.fatal.common.constants;

/**
 * 购物车常量
 * @author Fatal
 * @date 2019/8/15 0015 8:16
 */
public interface ShopCartConstant {

    /**
     * 购物车key前缀
     */
    String SHOP_CART = "SHOP_CART:%s";

    /**
     * 系统统一数据：单种sku允许添加到购物车的数额
     */
    Integer MAX = 10000;

    /**
     * 系统统一数据：允许添加到购物车sku种类的数额
     */
    Integer TYPE_MAX = 120;

    /**
     * 为购物车加上前缀
     * @param userId
     * @return
     */
    static String getKey(Long userId) {
        return String.format(ShopCartConstant.SHOP_CART, userId);
    }

}
