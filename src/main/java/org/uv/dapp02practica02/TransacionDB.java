package org.uv.dapp02practica02;

import java.sql.Connection;


public abstract class TransacionDB<T> {
    protected T pojo;
    
    public TransacionDB (T pojo){
        this.pojo=pojo;
    }
    
    public abstract boolean execute (Connection con);       
}
