package ww.free.com.twodanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    FrameLayout frame;
    ImageView pic1, pic2;
    private ScaleAnimation scaleAnimation1;
    private ScaleAnimation scaleAnimation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animaton_layout);
        initView();
    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        pic1 = (ImageView) findViewById(R.id.pic1);
        pic2 = (ImageView) findViewById(R.id.pic2);
        show1();
        scaleAnimation1 = new ScaleAnimation(1, 0, 1, 1, ScaleAnimation.RELATIVE_TO_PARENT, 0.5f, ScaleAnimation.RELATIVE_TO_PARENT, 0.5f);
        scaleAnimation2 = new ScaleAnimation(0, 1, 1, 1, ScaleAnimation.RELATIVE_TO_PARENT, 0.5f, ScaleAnimation.RELATIVE_TO_PARENT, 0.5f);
        scaleAnimation1.setDuration(500);
        scaleAnimation2.setDuration(500);
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pic1.getVisibility() == View.VISIBLE) {
                    pic1.startAnimation(scaleAnimation1);
                } else {
                    pic2.startAnimation(scaleAnimation1);
                }
                scaleAnimation1.setAnimationListener(animationlistener);
            }
        });
    }

    Animation.AnimationListener animationlistener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (pic1.getVisibility() == View.VISIBLE) {
                pic1.setAnimation(null);
                show2();
                pic2.startAnimation(scaleAnimation2);
            } else {
                pic2.setAnimation(null);
                show1();
                pic1.startAnimation(scaleAnimation2);
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    private void show1() {
        pic1.setVisibility(View.VISIBLE);
        pic2.setVisibility(View.GONE);
    }

    private void show2() {
        pic1.setVisibility(View.GONE);
        pic2.setVisibility(View.VISIBLE);
    }
}
