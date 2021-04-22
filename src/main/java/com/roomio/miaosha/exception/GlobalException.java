package com.roomio.miaosha.exception;

import com.roomio.miaosha.result.CodeMsg;

/**
 * @author biqiang
 * @version 2021/4/22
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
public class GlobalException extends RuntimeException{

    private static  final Long serialVersionUID =1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
    super(codeMsg.toString());
        this.codeMsg=codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
