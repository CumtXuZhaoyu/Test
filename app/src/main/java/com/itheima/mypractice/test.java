package com.itheima.mypractice;

import java.util.List;

/**
 * Created by XuZhaoyu on 2016/12/20.
 */

public class test {

    /**
     * listCount : 1500
     * productList : [{"id":"1102539","marketPrice":"79","name":"雅培金装","pic":"","price":"78"},{"id":"1102539","marketPrice":"79","name":"雅培金装","pic":"","price":"78"}]
     * response : favorites
     */

    private String listCount;
    private String response;
    /**
     * id : 1102539
     * marketPrice : 79
     * name : 雅培金装
     * pic :
     * price : 78
     */

    private List<ProductListBean> productList;

    public String getListCount() {
        return listCount;
    }

    public void setListCount(String listCount) {
        this.listCount = listCount;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<ProductListBean> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductListBean> productList) {
        this.productList = productList;
    }

    public static class ProductListBean {
        private String id;
        private String marketPrice;
        private String name;
        private String pic;
        private String price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(String marketPrice) {
            this.marketPrice = marketPrice;
        }

        public String getName() {
            return name;
        }

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
