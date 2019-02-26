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


        Button addData = (Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("这是我添加的数据-name");
                book.setAuthor("这是我添加的数据-作者");
                book.setPages(1000);
                book.setPress("sofia-home");
                book.setPrice(888);
                //最后一步 save
                book.save();
            }
        });


        Button updateData = (Button)findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setPrice(8881);
                book.setAuthor("这是更新的作者");
                book.updateAll("press = ?","sofia-home");
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
