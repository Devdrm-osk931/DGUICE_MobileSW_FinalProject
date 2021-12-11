package com.course.finalproject;

import java.io.Serializable;

public class Items implements Serializable {
    //itemclass 요소: 사진4개 브랜드 제품명 가격 설명
    int main_img_id, det_img_id1,det_img_id2,det_img_id3,price;
    String brand;
    String name;
    String description;

    public Items(int main,int img1,int img2,int img3,String brand,String name,int price,String description){
        this.main_img_id = main;
        this.det_img_id1 = img1;
        this.det_img_id2 = img2;
        this.det_img_id3 = img3;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //getter
    //메인페이지
    public int getMain_img_id() {
        return main_img_id;
    }
    public String getBrand() {
        return brand;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    //상세페이지
    public int getDet_img_id1(){
        return det_img_id1;
    }
    public int getDet_img_id2(){
        return det_img_id2;
    }
    public int getDet_img_id3(){
        return det_img_id3;
    }
    public String getDescription() {
        return description;
    }

}
