//package com.yupi.gudazi.once;
//
//import com.alibaba.excel.EasyExcel;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.util.StringUtil;
//import sun.jvm.hotspot.debugger.win32.coff.AuxSectionDefinitionsRecord;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
///**
// *
// * 导入星球用户到数据库
// */
//
//public class ImportXingQiuUser {
//
//    public static void main(String[] args) {
//        String fileName ="   ";
//        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
//        List<XingQiuTableUserInfo> userInfoList =
//                EasyExcel.read(fileName).head(XingQiuTableUserInfo.class).sheet().doReadSync();
//
//        System.out.println("总数=" + userInfoList.size());
//        Map<String, List<XingQiuTableUserInfo>> listMap =
//                userInfoList.stream()
//                        .filter(userInfo -> StringUtils.isNotEmpty(userInfo.getUsername()))
//                        .collect(Collectors.groupingBy(XingQiuTableUserInfo::getPlanetCode));
//        System.out.println("不重复的昵称数= " + listMap.keySet().size());
//    }
//
//}
