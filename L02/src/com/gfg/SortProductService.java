package com.gfg;

import java.util.List;

public class SortProductService {

    List<Product> sort(List<Product> productList){
        ProductSortingInterface productSortingInterface = null;
        if(productList.size() < 10){
            productSortingInterface = new ProductBubleSort();
        }
        if(productList.size() <100 && productList.size() >= 10){

        }
        else{
            productSortingInterface = new ProductMergeSort();
        }
        return productSortingInterface.sort(productList);
    }

}
