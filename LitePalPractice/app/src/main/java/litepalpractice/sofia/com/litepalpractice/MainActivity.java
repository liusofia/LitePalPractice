package litepalpractice.sofia.com.litepalpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //一次最简单的数据库操作
                Connector.getDatabase();
            }
        });
        /**
         *
         * 查看 litepal 创建表语句
         sqlite> .schema
         CREATE TABLE android_metadata (locale TEXT);
         CREATE TABLE table_schema (id integer primary key autoincrement,name text, type integer);
         CREATE TABLE sqlite_sequence(name,seq);
         CREATE TABLE book (id integer primary key autoincrement,author text, name text, pages integer, price real);
         *
         */
    }
}
