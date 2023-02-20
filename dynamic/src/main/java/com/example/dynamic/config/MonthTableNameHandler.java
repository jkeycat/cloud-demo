package com.example.dynamic.config;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;

import java.util.Arrays;
import java.util.List;

public class MonthTableNameHandler implements TableNameHandler {
    //用于记录那些表可以使用该月份动态表名处理器
    private List<String> tableNames;
    //构造函数，构造动态表明处理器的时候传入tableNames;
    public  MonthTableNameHandler(String ...tableNames){
             this.tableNames= Arrays.asList(tableNames);
    }
    //每个请求线程维护一个month数据，避免多线程冲突，所以使用ThreadLocal
    private  static  final  ThreadLocal<String> MONTH_DATA=new ThreadLocal<>();
    //设置请求线程的month数据
    public  static  void setMonthData(String month){
        MONTH_DATA.set(month);
    }
    //删除当前请求线程的数据
    public  static  void removeData(){
        MONTH_DATA.remove();
    }

    @Override
    public String dynamicTableName(String sql, String tableName) {
        if(this.tableNames.contains(tableName)){
            return  tableName+"_"+MONTH_DATA.get();//表名增加月份后缀
        }else {
            return tableName;
        }

    }
}
