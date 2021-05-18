package com.choutianxius.javaengineering.libraryassistant.core;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * 领域实体 - 球员
 *
 * @author octopusthu@gmail.com
 */
    public class Assistant {

    /**
     * 助理队员 ID
     */
    @Getter
    private final Integer id;

    /**
     * 助理队员姓名
     */
    @Getter
    private final String name;

    /**
     * 助理队员联系方式
     */
    @Getter
    @Setter
    private String phone;

    /**
     *  队员等级，freshman, skilled, manager, boss
     */
    @Getter
    @Setter
    private String rank;

    /**
     *  总工时
     */
    @Getter
    @Setter
    private Double TotalHours;

    /**
     *  本周工时
     */
    @Getter
    @Setter
    private Double CurrentHours;

    public Assistant(Integer id, String name, String phone) {
        Assert.notNull(id, "id cannot be null");
        /**
         * 暂时不考虑name和phone的格式问题
         */
        Assert.isTrue(StringUtils.isNotBlank(name), "name cannot be blank");
        Assert.isTrue(StringUtils.isNotBlank(phone), "phone cannot be blank");
        this.id = id;
        this.name = name;
        this.phone = phone;
        /**
         * 新队员只能是freshman
         */
        this.rank = "freshman";
        this.TotalHours = 0d;
        this.CurrentHours = 0d;
    }

}
