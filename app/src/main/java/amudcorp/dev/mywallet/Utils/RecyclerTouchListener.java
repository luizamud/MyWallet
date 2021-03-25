package amudcorp.dev.mywallet.Utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import static androidx.recyclerview.widget.RecyclerView.*;

public  class RecyclerTouchListener implements OnItemTouchListener{

    private ClickListener clicklistener;
    private GestureDetector gestureDetector;
    public interface ClickListener{
       void onClick(View view, int position);
       boolean onLongClick(View view, int position);
    }

    public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){

        this.clicklistener=clicklistener;
        gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                if(child!=null && clicklistener!=null){
                    clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child=rv.findChildViewUnder(e.getX(),e.getY());
        if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
            clicklistener.onClick(child,rv.getChildAdapterPosition(child));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
    /**Adding Click Listeners to RecyclerView
        Now let’s add the ItemTouchListener to the RecyclerView, where we will pass RecyclerTouchListener class. This will implement onClick and onLongClick methods.These methods will listen for the click and long press events on the particular position of the view.
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
        recyclerView, new ClickListener() {
@Override
public void onClick(View view, final int position) {
        //Values are passing to activity & to fragment as well
        Toast.makeText(MainActivity.this, "Single Click on position        :"+position,
        Toast.LENGTH_SHORT).show();
        }

@Override
public void onLongClick(View view, int position) {
        Toast.makeText(MainActivity.this, "Long press on position :"+position,
        Toast.LENGTH_LONG).show();
        }
        }));
     **/