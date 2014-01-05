package jp.kkyouhei.pipeline;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridLayout;

public class PlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        GameBlockController gbController = GameBlockController.getInstance(this);
        GridLayout gb = (GridLayout)this.findViewById(R.id.GameBoard);
        gbController.addGameBlock(gb);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
