package nz.co.kiwiandroiddev.distractionfreereadingpart1;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

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
                    }

                    @Override
                    public void onStartScrollingUp() {
                        actionButton.show();
                    }
                });
    }

}
