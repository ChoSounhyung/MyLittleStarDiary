package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;

public class StarActivity extends AppCompatActivity {
    public static final String EXTRA_DATE = "com.mirinae.mylittlestardiary.EXTRA_DATE";
    public static final String EXTRA_TEXT = "com.mirinae.mylittlestardiary.EXTRA_TEXT";

    private ImageView bottle, fish, sheep, ox, twin, crab, lion, woman, balance, scorpion, centaur, goat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        init();
        setBottomNav();
        setUp();

    }

    public void init() {
        bottle = findViewById(R.id.star_bottle_btn);
        fish = findViewById(R.id.star_fish_btn);
        sheep = findViewById(R.id.star_sheep_btn);
        ox = findViewById(R.id.star_ox_btn);
        twin = findViewById(R.id.star_twin_btn);
        crab = findViewById(R.id.star_crab_btn);
        lion = findViewById(R.id.star_lion_btn);
        woman = findViewById(R.id.star_woman_btn);
        balance = findViewById(R.id.star_balance_btn);
        scorpion = findViewById(R.id.star_scorpion_btn);
        centaur = findViewById(R.id.star_centaur_btn);
        goat = findViewById(R.id.star_goat_btn);
    }

    public void setUp() {
        bottle.setOnClickListener(goDetailPage);
        fish.setOnClickListener(goDetailPage);
        sheep.setOnClickListener(goDetailPage);
        ox.setOnClickListener(goDetailPage);
        twin.setOnClickListener(goDetailPage);
        crab.setOnClickListener(goDetailPage);
        lion.setOnClickListener(goDetailPage);
        woman.setOnClickListener(goDetailPage);
        balance.setOnClickListener(goDetailPage);
        scorpion.setOnClickListener(goDetailPage);
        centaur.setOnClickListener(goDetailPage);
        goat.setOnClickListener(goDetailPage);
    }

    View.OnClickListener goDetailPage = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), StarDetailActivity.class);
            switch (view.getId()) {
                case R.id.star_bottle_btn:
                    intent.putExtra("image", R.drawable.star_bottle);
                    intent.putExtra(EXTRA_DATE, "1/20~2/18");
                    intent.putExtra(EXTRA_TEXT, " 가니메데는 트로이에 살던 소년으로 매우 아름다워 그 아름다움이 천상계에 전해지게 되었대요. 이 소문을 들은 제우스는 독수리로 변하여 트로이에 갔대요. 트로이에서 양을 쫓던 가니메데를 본 제우스는 한눈에 반했다고 해요. 제우스는 독수리의 발톱으로 가니메데를 붙잡아 천상계로 데려가 영원한 젊음과 생명을 주고, 신들이 마시는 넥타르라는 음료를 잔에 부어 돌리는 역할을 맡겼대요. 가니메데는 제우스의 총애를 받아 물병자리가 되었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_fish_btn:
                    intent.putExtra("image", R.drawable.star_fish);
                    intent.putExtra(EXTRA_DATE, "2/19~3/20");
                    intent.putExtra(EXTRA_TEXT, " 어느 날 아프로디테와 아들 에로스가 강 언덕을 건너고 있었대요. 그런데 갑자기 거인 타이폰이 나타나 아프로디테와 에로스를 깜짝 놀라게 했대요. 아프로디테는 아들을 잃어버리지 않도록 자신의 발과 에로스 발을 묶고 함께 물고기로 변신해서 강 속으로 도망을 쳤대요. 이때 도망치던 모습을 아테네가 이들의 탈출을 기념하기 위해 별자리로 만들었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_sheep_btn:
                    intent.putExtra("image", R.drawable.star_sheep);
                    intent.putExtra(EXTRA_DATE, "3/21~4/19");
                    intent.putExtra(EXTRA_TEXT, " 보이오티아 왕 아타마스의 두 아이 프릭소스와 헬레 남매의 이야기에요. 남매의 친어머니인 구름의 요정 네펠레는 계모의 속임수로 인해 제물로 바쳐져 죽을 위기에 처한 자기 자식들의 모습을 보고 제우스에게 도움을 청했대요. 그래서 제우스는 헤르메스를 통해 하늘을 달리는 황금 양을 보내 아이들을 돕게 했대요. 이 황금 양이 후에 하늘에 올라가 양자리가 되었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_ox_btn:
                    intent.putExtra("image", R.drawable.star_ox);
                    intent.putExtra(EXTRA_DATE, "4/20~5/20");
                    intent.putExtra(EXTRA_TEXT, " 제우스가 페니키아의 공주를 유혹하기 위해 흰 황소로 변신했다고 해요. 변한 제우스는 목장에서 놀고 있는 공주를 크레타 섬으로 데려갔대요. 여기서 제우스는 원래 자기 모습으로 돌아와 공주와 결혼을 했고, 제우스가 변했던 흰 소를 기념하여 별자리를 만들었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_twin_btn:
                    intent.putExtra("image", R.drawable.star_twin);
                    intent.putExtra(EXTRA_DATE, "5/21~6/21");
                    intent.putExtra(EXTRA_TEXT, " 제우스와 레아라는 여인의 사이에서 태어난 카스토르와 풀룩스는 사이가 매우 좋은 형제였대요. 어느 날 친척과의 싸움으로 카스토르가 죽어서 풀룩스는 아버지인 제우스에게 자신의 생명 반을 카스토르에게 달라고 소원을 빌었대요. 이에 감동을 받은 제우스는 카스토르와 풀룩스를 울림포스에서 살게 하고 하루의 반은 지하세계에서 살게 해주고 별자리도 만들어주었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_crab_btn:
                    intent.putExtra("image", R.drawable.star_crab);
                    intent.putExtra(EXTRA_DATE, "6/22~7/22");
                    intent.putExtra(EXTRA_TEXT, " 히드라라는 머리가 아홉 개 달리 뱀과 헤라클레스가 대혈전을 벌였다고 해요. 헤라는 히드라를 도와 헤라클레스를 없애기 위해 보낸 거대한 게로 헤라클레스의 발가락을 물었지만 분노한 헤라클래스의 발에 밟혀 죽고 말았대요. 헤라는 죽은 게에게 보답하기 위해 별자리로 만들어주었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_lion_btn:
                    intent.putExtra("image", R.drawable.star_lion);
                    intent.putExtra(EXTRA_DATE, "7/23~8/22");
                    intent.putExtra(EXTRA_TEXT, " 네메아 숲에 무시무시한 황금빛 사자가 살았대요. 이 사자는 사람들을 괴롭혀서 많은 사람들이 고통을 받았데요. 이를 참을 수 없었던 헤라클레스는 사자를 죽였대요. 헤라클레스의 승리를 기념하기 위해 이 사자를 별자리로 만들었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_woman_btn:
                    intent.putExtra("image", R.drawable.star_woman);
                    intent.putExtra(EXTRA_DATE, "8/23~9/23");
                    intent.putExtra(EXTRA_TEXT, " 대지의 여신 데메테르에게는 아름다운 봄의 여신 페르세포네라는 딸이 있었어요. 그런데 지옥의 왕인 하데스가 페르세포네를 강제로 납치해 아내로 삼았대요. 딸을 잃은 데메테르는 슬픔에 잠겨 대지에는 봄이 오지 않았고, 제우스는 1년의 6개월을 지하에서 남편과 살고 나머지 반은 지상에서 엄마인 데메테르와 살게 했대요. 데메테르의 모습을 본떠 처녀자리를 만들었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_balance_btn:
                    intent.putExtra("image", R.drawable.star_balance);
                    intent.putExtra(EXTRA_DATE, "9/24~10/22");
                    intent.putExtra(EXTRA_TEXT, " 정의의 여신인 아스트라이아는 인간에게 싸우지 않고 사이좋게 사는 여러 가지 방법을 알려주었대요. 그런데도 인간들이 자꾸만 싸워서 인간 세상을 버리고 하늘로 올라갔대요. 하늘에서도 인가의 옳고 그름을 판단해 주었대요. 그때 사용했던 저울이 천칭자리가 되었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_scorpion_btn:
                    intent.putExtra("image", R.drawable.star_scorpion);
                    intent.putExtra(EXTRA_DATE, "10/23~11/22");
                    intent.putExtra(EXTRA_TEXT, " 오리온은 매우 오만하여 세상의 모든 동물들을 죽일 수 있다고 떠들고 다녔대요. 올림포스 신들은 화가 났고 결구 헤라가 오리온을 죽이기 위해 전갈을 풀었대요. 오리온은 결국 죽었고. 오리온을 죽인 공로로 전갈을 하늘의 별자리가 되었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_centaur_btn:
                    intent.putExtra("image", R.drawable.star_centaur);
                    intent.putExtra(EXTRA_DATE, "11/23~12/24");
                    intent.putExtra(EXTRA_TEXT, " 케이론은 머리는 사람이고 몸은 말인 켄타우로스 족이었는데, 아주 훌륭하고 지혜로웠대요. 케이론은 아르고호를 타고 황금 양피를 찾아 나선 제자들을 안내하기 위해 스스로 자신의 모습을 별자리로 만들었다는 이야기가 전해와요.");
                    startActivity(intent);
                    break;
                case R.id.star_goat_btn:
                    intent.putExtra("image", R.drawable.star_goat);
                    intent.putExtra(EXTRA_DATE, "12/25~1/19");
                    intent.putExtra(EXTRA_TEXT, " 제우스는 어렸을 때 크로노스에게서 마지막 남은 아들을 살리기 원했던 자신의 어머니 레아가 할머니인 가이아의 도움을 받아 몰래 빼돌려져서 크레타 섬의 요정들의 손에 자라게 되었어요. 이들 중 그곳의 요정들의 리더로 존재였던 염소 모습의 요정 아말테이아가 제우스를 자신의 양아들로 삼아 자신의 젖으로 제우스를 키웠다고 해요. 이후 성장하여 성인이 된 제우스는 티타노마키아를 준비하던 중 크레타에서 온 요정에게 염소 가죽을 받게 되었는데 그 가죽은 바로 아말테이아의 가죽이었데요. 아말테이아는 죽으면서 유언으로 자신의 가죽을 제우스에게 전해달라고 부탁했고 제우스는 자신을 돌봐준 양어머니인 아말테이아의 죽음에 슬퍼하며 자신을 돌봐준 그녀의 은혜에 보답하기 위해 그녀를 별자리로 다시 태어나게 만들었다는 이야기가 전해 와요.");
                    startActivity(intent);
                    break;
            }
        }
    };

    public void setBottomNav() {
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.star);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.star:
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

}