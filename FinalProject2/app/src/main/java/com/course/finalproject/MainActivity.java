package com.course.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = (RecyclerView)findViewById(R.id.item_list);
        myRecyclerView.setHasFixedSize(false);
        myLayoutManager = new GridLayoutManager(this, 2);
        myRecyclerView.setLayoutManager(myLayoutManager);

        Button cs_button = (Button) findViewById(R.id.cs_button);
        cs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomerService.class);
                startActivity(intent);
            }
        });


        //item class에 대한 배열 선언할것 -> 메인 리사이클러뷰에 표시할 아이템
        //main에 나타날 것: 메인사진, 브랜드, 이름
        //상세페이지에 나타날 것: 브랜드로고 사진 맨위에, 메인사진, 제품명, 가격, 상세사진 1~3, 설명

        //public Items(int main,int img1,int img2,int img3,String brand,String name,int price,String description)
        ArrayList<Items> itemInfo = new ArrayList<>();
        itemInfo.add(new Items(R.drawable.g304_main, R.drawable.g304_det1, R.drawable.g304_det2, R.drawable.g304_det3, "Logitech", "G304 Wireless",
                34000, "Logitech 사에서 독자적으로 개발한 Hero 센서가 탑재된 게이밍 마우스입니다. USB 동글을 통해 무선연결을 지원하며, 배터리는 AA 배터리 1개를 필요로 합니다. 가성비와 성능을 동시에 챙긴 모델입니다. 가격이 저렴하다고 성능을 의심하지 마십시오!."));
        itemInfo.add(new Items(R.drawable.viper_main, R.drawable.viper_det1, R.drawable.viper_det2, R.drawable.viper_det3, "Razer", "Razer Viper Ultimate", 159000,
                "Razer사가 개발한 무선 게이밍 마우스. 충전을 위한 충전 Dock이 동봉되어 있습니다. 이 마우스와 함께라면 당신도 프로게이머가 될 수 있습니다"));
        itemInfo.add(new Items(R.drawable.owleye_main, R.drawable.owleye_det1, R.drawable.owleye_det2, R.drawable.owleye_det3, "Roccat", "Owl-Eye Ultra", 68000,
                "독일 로캣사에서 개발한 게이밍 마우스. 무게가 매우 가벼운 것이 특징이며, 소형 사이즈의 게이밍 마우스입니다. 배틀그라운드 프로게이머 다수가 애용하는 인기 마우스입니다."));
        itemInfo.add(new Items(R.drawable.basilisk_main, R.drawable.basilisk_det1, R.drawable.basilisk_det2, R.drawable.basilisk_det3, "Razer", "Basilisk V3", 85000,
                "11개의 프로그래밍이 가능한 버튼이 탑재된 게이밍마우스. 사용하는 프로그램과 개인취향에 맞게 커스터마이즈 하세요! 인체공학적인 디자인으로 사용자에게 최상의 경험을 선사합니다."));
        itemInfo.add(new Items(R.drawable.deathadder_main, R.drawable.deathadder_det1, R.drawable.deathadder_det2, R.drawable.deathadder_det3, "Razer", "Deathadder", 13000,
                "수십년이 지나도 변치않는 인기, 레이저 사의 데스에더의 인체공학적 디자인은 여러 타사의 귀감이 되어 내려오고 있습니다. 계속해서 발전하는 데스에더를 이제 무선으로 사용해보세요."));
        itemInfo.add(new Items(R.drawable.gpro_main, R.drawable.gpro_det1, R.drawable.gpro_det2, R.drawable.gpro_det3, "Logitech", "GPro X Superlight", 190000,
                "많은 사랑을 받았던 GPro Wireless가 더욱 경량화가 이루어졌습니다. 더욱 가벼워진 GPro Wireless x Superlight 와 함께 모니터 속 전장을 누려보세요."));
        itemInfo.add(new Items(R.drawable.mz1_main, R.drawable.mz1_det1, R.drawable.mz1_det2, R.drawable.mz1_det3, "Xtrfy", "MZ1-Zy's Rail", 114000,
                "호주의 Xtrfy사와 마우스리뷰 전문 유튜버 RocketJumpNinja가 협업하여 만든 초경량 게이밍 마우스. 경량화와 화려한 RGB, 그리고 유연한 케이블 3박자를 모두 챙긴 게이밍마우스입니다."));
        itemInfo.add(new Items(R.drawable.starlight_main, R.drawable.starlight_det1, R.drawable.starlight_det2, R.drawable.starlight_det3, "Finalmouse", "Starlight", 200000,
                "마우스 업계에 경량 열풍을 불러들인 장본인인 Finalmouse 사가 야심차게 선보이는 최신작 게이밍 무선 마우스입니다. 마그네슘 합금으로 이루어진 쉘과 전매특허인 타공 디자인을 합하여 지금까지 없던 40g대의 초경량 마우스를 만들어 선보인다. 세계적인 품절대란으로 구하기 쉽지 않은 게이머들의 it아이템! 지금 바로 만나보세요."));
        itemInfo.add(new Items(R.drawable.mxmaster_main, R.drawable.mxmaster_det1, R.drawable.mxmaster_det2, R.drawable.mxmaster_det3, "Logitech", "MX Vertical", 119000,
                "장시간 컴퓨터 앞에서의 업무, 일반 마우스의 장시간 사용은 손목 터널 증후군을 유발할 수 있습니다. 인체공학적으로 Verticall Designed MX Vertical 과 함께 업무와 손목 건강 두 마리 토끼를 한번에 잡아보세요"));
        itemInfo.add(new Items(R.drawable.abko_main, R.drawable.abko_det1, R.drawable.abko_det2, R.drawable.abko_det3, "Abko", "WM550 무소음 마우스", 16000,
                "조용한 카페나 독서실에서의 마우스의 소음은 남들에게 많은 피해를 줄 수 있지만, 앱코의 무소음 마우스는 이러한 걱정을 없애드립니다. 또한 블루투스 연결을 지원하여 usb 포트가 추가적으로 필요 없습니다. 가성비가 뛰어난 제품입니다."));
        itemInfo.add(new Items(R.drawable.hansung_main, R.drawable.hansung_det1, R.drawable.hansung_det2, R.drawable.hansung_det3, "Hansung", "BM100 Dual 저소음마우스", 13000,
                "블루투스/USB동글 두가지 방식으로 듀얼 커넥션이 가능한 무선 저소음 마우스입니다. 한번에 여러 기기에 페어링이 가능한 멀티페어링 기능이 탑재되어 있으므로, 그때그때 다른 기기로 편하게 스위칭이 가능합니다. 또한 다양한 색으로 출시가 되어 다양한 고객님들의 취향을 맞출 수 있는 디자인과 가성비가 뛰어난 제품입니다."));

        MyAdapter myAdapter = new MyAdapter(itemInfo);
        myRecyclerView.setAdapter(myAdapter);
        RecyclerDecoration myDecoration = new RecyclerDecoration(40);
        myRecyclerView.addItemDecoration(myDecoration);
    }
}