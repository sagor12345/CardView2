package info.androidhive.cardview;

import android.content.Context;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);


            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int[] img = {R.drawable.album1, R.drawable.album2,
                            R.drawable.album3, R.drawable.album4,
                            R.drawable.album5, R.drawable.album6,
                            R.drawable.album7, R.drawable.album8,
                            R.drawable.album9, R.drawable.album10
                    };

                    if (getLayoutPosition() == 0) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh1";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[0]);
                        view.getContext().startActivity(intent);
                    }

                    if (getLayoutPosition() == 1) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh2";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[1]);
                        view.getContext().startActivity(intent);
                    }
                    if (getLayoutPosition() == 2) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh3";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[2]);
                        view.getContext().startActivity(intent);
                    }
                    if (getLayoutPosition() == 3) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh4";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[3]);
                        view.getContext().startActivity(intent);
                    }
                    if (getLayoutPosition() == 4) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh5";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[4]);
                        view.getContext().startActivity(intent);
                    }
                    if (getLayoutPosition() == 5) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh6";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[5]);
                        view.getContext().startActivity(intent);
                    }
                    if (getLayoutPosition() == 6) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh7";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[6]);
                        view.getContext().startActivity(intent);
                    }
                    if (getLayoutPosition() == 7) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh8";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[7]);
                        view.getContext().startActivity(intent);
                    }
                    if (getLayoutPosition() == 8) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh9";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[8]);
                        view.getContext().startActivity(intent);
                    }
                    if (getLayoutPosition() == 9) {
                        Toast.makeText(mContext, "Hello " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                        String name = "Hello Bangladesh10";
                        Intent intent = new Intent(view.getContext(), Details.class);
                        intent.putExtra("key", name);
                        intent.putExtra("img", img[9]);
                        view.getContext().startActivity(intent);
                    }


                    // Toast.makeText(mContext, "Hello", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs() + " songs");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position==0){
                    String name = "Hello Bangladesh";
                    Intent intent = new Intent(mContext,Details.class);
                    intent.putExtra("key",name);
                    intent.putExtra("img", (Parcelable) album);
                }
            }
        });*/

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);

            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {


        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
