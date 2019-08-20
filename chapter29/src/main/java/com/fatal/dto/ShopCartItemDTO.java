package com.fatal.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 购物车skuDTO，去掉了重复的属性
 * @desc @EqualsAndHashCode 这里只选择了两个属性，是为了后面去重；先去重后map，可以减少大部分操作。
 * @author Fatal
 * @date 2019/8/15 0015 17:45
 */
@Data
@Accessors(chain = true)
public class ShopCartItemDTO {

    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品名称（冗余字段）
     */
    private String goodsName;

    /**
     * sku单价（单位：分）
     */
    private Long price;

    /**
     * sku库存
     */
    private Integer stock;

    /**
     * sku图片
     */
    private String picture;

    /**
     * 规格（规格本来应该是张表的，这里为了方便，就直接 String）
     */
    private String properties;

    /**
     * 允许添加到购物车的最大数额
     */
    private Integer max;

    /**
     * sku状态：-1 下架; 0 删除; 1 在架
     */
    private Integer status;

    private static ShopCartItemDTO of(ShopCartSkuDTO shopCartSkuDTO) {
        ShopCartItemDTO shopCartItemDTO = new ShopCartItemDTO();
        BeanUtils.copyProperties(shopCartSkuDTO, shopCartItemDTO);
        return shopCartItemDTO;
    }

    public static List<ShopCartItemDTO> of(List<ShopCartSkuDTO> shopCartSkuDTOs) {
        return shopCartSkuDTOs.stream()
                .map(ShopCartItemDTO::of)
                .collect(Collectors.toList());
    }

}
