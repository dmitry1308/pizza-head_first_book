package ru.shepin.pizza_head_first_book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private ShareActionProvider actionProvider;

    private String[] titles;
    private ListView drawerList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
         titles = getResources().getStringArray(R.array.titles);

        drawerList = (ListView) findViewById(R.id.drawerr);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                titles);

        drawerList.setAdapter(arrayAdapter);

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_share);
        actionProvider = (ShareActionProvider) item.getActionProvider();
        setIntent("This is exampleText");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        actionProvider.setShareIntent(intent);
    }

}