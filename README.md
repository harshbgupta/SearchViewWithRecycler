# SearchViewWithRecycler
Now you can Search your data in recycler View


For developing SearchViewInMenuWithRecycler follow the following steps:

Step 1: First Create A Simple Recycler View With Adapter by Following Code

    a) Create MainActivity Like as
    public class MainActivity extends AppCompatActivity {


        RecyclerView recyclerView;
        ArrayList<String> list = new ArrayList<>();
        AdapterClass adapterClass;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            recyclerView = (RecyclerView) findViewById(R.id.recycler);

            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            list.add("abc");
            list.add("bcd");
            list.add("cde");
            list.add("def");
            list.add("efg");
            list.add("fgh");
            list.add("ghi");
            list.add("hij");
            list.add("ijk");
            list.add("klm");
            list.add("lmn");
            list.add("mno");
            list.add("nop");
            list.add("opq");
            list.add("pqr");
            list.add("qrs");
            list.add("rst");
            list.add("stu");
            list.add("tuv");
            list.add("uvw");
            list.add("vwx");
            list.add("wxy");
            list.add("wyz");

            adapterClass = new AdapterClass(MainActivity.this,list);
            recyclerView.setAdapter(adapterClass);

        }
    }


    b)  //Adapter Calss

    class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolders> {
        Context context;
        ArrayList<String> list;
        ViewHolders viewHolders;

        public AdapterClass(Context context, ArrayList<String> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter, null);
            viewHolders = new ViewHolders(view);
            return viewHolders;
        }

        @Override
        public void onBindViewHolder(ViewHolders holder, int position) {
            holder.text.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }


        public static class ViewHolders extends RecyclerView.ViewHolder {

            public TextView text;

            public ViewHolders(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.text);

            }
        }
    }

    c)  //Here is your xml files activit_main

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:orientation="vertical"
        android:layout_height="match_parent"
        tools:context="com.h5c.searchbar.MainActivity">

        <android.support.v7.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/recycler">

        </android.support.v7.widget.RecyclerView>

    </LinearLayout>

    d) //adapter xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical" android:layout_width="match_parent"
        android:gravity="center_horizontal"
        android:layout_height="wrap_content">

        <TextView
            android:layout_width="match_parent"
            android:id="@+id/text"
            android:layout_margin="5dp"
            android:layout_marginLeft="15dp"
            android:layout_height="50dp" />

    </LinearLayout>

Step 2:

    Create a menu resourse directory in res folder

Step 3:

    Create a menu file like follows:

    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">
        <item
            android:id="@+id/action_search"
            android:icon="@drawable/ic_action_search"
            android:title="Search"
            app:actionViewClass="android.support.v7.widget.SearchView"
            app:showAsAction="always|collapseActionView"></item>
    </menu>

Step 4:
      Now Add following method in MainActivity Class

       @Override
          public boolean onCreateOptionsMenu(Menu menu) {
              getMenuInflater().inflate(R.menu.menu_items,menu);
              MenuItem menuItem = menu.findItem(R.id.action_search);
              SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
              searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                  @Override
                  public boolean onQueryTextSubmit(String query) {
                      return false;
                  }

                  @Override
                  public boolean onQueryTextChange(String newText) {
                      newText = newText.toLowerCase();
                      ArrayList<String> listsearch = new ArrayList<String>();
                      for(int i = 0; i< list.size();i++){
                          if(((list.get(i)).toLowerCase()).contains(newText)){
                              listsearch.add(list.get(i));
                          }else{
                              Log.d("Harsh","Not Mached");
                          }
                      }
                      adapterClass.setFilter(listsearch);
                      return true;
                  }
              });
              return true;
          }

Step 5:
    Add this in AdapterClass (Not ib View Holder class)
    public void setFilter(ArrayList<String> list){
            this.list = new ArrayList<>();
            this.list.addAll(list);
            notifyDataSetChanged();
    }


Step 6:
    Here we go !!!
    Now your Project is Ready


