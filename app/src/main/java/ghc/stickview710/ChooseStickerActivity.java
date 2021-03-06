package ghc.stickview710;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by guohongcheng on 2017/8/30.
 */

public class ChooseStickerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;

    /*private OnStickerGridClickListener mOnStickerGridClickListener;


    public interface OnStickerGridClickListener {
        void onStickerGridClickListener();
    }*/

    private Integer[] images = {
            R.drawable.icon_0, R.drawable.icon_1,
            R.drawable.icon_2, R.drawable.icon_3,
            R.drawable.icon_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_choose_sticker);

        gridView = (GridView) findViewById(R.id.stickerGridView);

        GridStickerAdapter pictureAdapter = new GridStickerAdapter(images, this);

        gridView.setAdapter(pictureAdapter);
        gridView.setOnItemClickListener(this);

    }

    //每个Grid Item的点击事件，需要传递给Activity做处理
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("ChooseStickerActivity", "position click " + position);

        ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);

        Intent intent = new Intent(this, StickerViewActivity.class);
        intent.putExtra(StickerViewActivity.STICKER_UP, position);
        ActivityCompat.startActivity(this, intent, compat.toBundle());
    }
}

