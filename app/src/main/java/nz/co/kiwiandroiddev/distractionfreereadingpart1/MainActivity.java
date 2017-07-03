package nz.co.kiwiandroiddev.distractionfreereadingpart1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionButton = (FloatingActionButton) findViewById(R.id.fab);
        setupToolbar();
        setupScrollView();
    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    private void setupScrollView() {
        NestedScrollView scrollView =
                (NestedScrollView) findViewById(R.id.nested_scrollview);

        scrollView.setOnScrollChangeListener(
                new OnScrollDirectionChangedListener() {
                    @Override
                    public void onStartScrollingDown() {
                        actionButton.hide();
                        hideToolbar();
                    }

                    @Override
                    public void onStartScrollingUp() {
                        actionButton.show();
                        showToolbar();
                    }
                });
    }

    private void hideToolbar() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_and_fade_out_to_top);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                toolbar.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        toolbar.startAnimation(animation);
    }

    private void showToolbar() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_and_fade_in_from_top);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                toolbar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        toolbar.startAnimation(animation);
    }

}
