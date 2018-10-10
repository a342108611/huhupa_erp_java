package com.huhupa.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortUtil {

	public static final String DEFAULT_ORDER = "desc";

	/**
	 * 
	 * @param list 为Map对象的集合 
	 * @param sort 按此字段排序
	 * @param order 制定升序还是降序
	 */
	@SuppressWarnings("unchecked")
	public static void sort(List list,final String sort,final String order) {
		Collections.sort(list, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1 = o1.get(sort).toString() ;//name1是从你list里面拿出来的一个 
                String name2 = o2.get(sort).toString() ; //name1是从你list里面拿出来的第二个name
                
                if(DEFAULT_ORDER.equals(order)) {
                	return name2.compareTo(name1);
                }else {
                	return name1.compareTo(name2);
                }
            }
        });
	}
}
