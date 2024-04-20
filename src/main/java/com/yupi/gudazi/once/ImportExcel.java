package com.yupi.gudazi.once;

/*导入Excel数据
*
*
*
* */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.util.ListUtils;

import java.io.File;
import java.util.List;
import java.util.Map;
/*导入Excel数据
 *
 *读取数据
 *
 * */

public class ImportExcel {
    public static void main(String[]args){

        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName ="   ";
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置

        readByListener(fileName);
        synchronousRead(fileName);
    }

/**
*
* 监听器读取
*@param fileName
* */
    public static void readByListener(String fileName) {
        EasyExcel.read(fileName, XingQiuTableUserInfo.class, new TableListener()).sheet().doRead();
    };

    /**同步读
   * @param fileName
   */
    public static void synchronousRead(String fileName) {

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<XingQiuTableUserInfo> totalDataList =
                EasyExcel.read(fileName).head(XingQiuTableUserInfo.class).sheet().doReadSync();
        for (XingQiuTableUserInfo xingQiuTableUserInfo:totalDataList){
            System.out.println(xingQiuTableUserInfo);
        }
    }


}
