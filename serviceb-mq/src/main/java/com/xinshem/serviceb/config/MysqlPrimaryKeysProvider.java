//package com.xinshem.serviceb.config;
//
//import com.codingapi.txlcn.tc.core.transaction.txc.analy.def.PrimaryKeysProvider;
//import com.google.common.collect.Maps;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author lzx
// * @date 2019/4/25 18:47
// */
//public class MysqlPrimaryKeysProvider implements PrimaryKeysProvider {
//    @Override
//    public Map<String, List<String>> provide() {
//        HashMap<String, List<String>> stringListHashMap = new HashMap<>();
//
//        stringListHashMap.put("tableb", Collections.singletonList("id"));
//        return Maps.newHashMap(stringListHashMap);
////        return Maps.newHashMap("tperson", Collections.singletonList("fid"));
//    }
//}
