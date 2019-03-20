package com.gwg.demo.constants;

/**
 *
 */
public interface GlobalConstants {

    String SEARCH_VERSION_2 = "2";

    String SEARCH_VERSION_3 = "3";

    Integer Y = new Integer(1);

    Integer N = new Integer(0);

    int PAGE_SIZE = 10;

    int MAX_PAGE = 100;

    String KEY_UP_NUM = "upnum";

    String KEY_DOWN_NUM = "downnum";

    String CACHE_KEY_PRODUCT_UPDOWN_COUNT = "productUpDownCount";

    String CACHE_KEY_PRODUCT_LIST = "productList";

    String CACHE_KEY_SKU_LIST = "skuList";

    String CACHE_KEY_ACTIVITY_SKU_SET = "activitySkuSet";

    String CACHE_KEY_MEMBER_LIST = "cacheMemberList";

    String CACHE_KEY_ACTIVITY_LIST = "activityList";

    String CACHE_KEY_PRODUCT_INFO = "productInfo";

    String CACHE_KEY_PRODUCT_SIZE = "productSize";

    String KEY_CACHE_TRIPLE_SUFFIX = "#p0.toString().concat(':').concat(#p1.toString()).concat(':').concat(#p2.toString())";

    String KEY_CACHE_DOUBLE_SUFFIX = "#p0.toString().concat(':').concat(#p1.toString())";


    String KEY_TEST = "#p0.toString()";

}
