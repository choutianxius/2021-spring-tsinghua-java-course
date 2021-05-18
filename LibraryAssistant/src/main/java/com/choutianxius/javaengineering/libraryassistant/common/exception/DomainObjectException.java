package com.choutianxius.javaengineering.libraryassistant.common.exception;

/**
 * 对领域实体进行新增、修改、删除、查询等操作时发生的异常
 *
 * @author octopusthu@gmail.com
 */
public class DomainObjectException extends RuntimeException {
    public DomainObjectException(String message) {
        super(message);
    }

    public DomainObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainObjectException(Throwable cause) {
        super(cause);
    }
}
