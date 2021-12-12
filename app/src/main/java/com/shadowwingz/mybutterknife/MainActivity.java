package com.shadowwingz.mybutterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.shadowwingz.lib_reflection.BindView;
import com.shadowwingz.lib_reflection.Binding;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.tv_show)
  TextView tvShow;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Binding.bind(this);

    tvShow.setText("我是测试文本");
  }
}