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
     *  队员等级，freshman, skilled, captain, boss
     */
    //@Getter
    //private EnumClass.Rank rank;

    public Assistant(Integer id, String name, String phone) {
        /**
         * 学号和姓名不能为空
         */
        Assert.notNull(id, "id cannot be null");
        Assert.isTrue(StringUtils.isNotBlank(name), "name cannot be blank");
        this.id = id;
        this.name = name;
        this.phone = phone;
        /**
         * 新队员只能是freshman
         */
        //this.rank = EnumClass.Rank.freshman;
    }

    public Assistant(Integer id, String name) {
        this(id, name, null);
    }

}
