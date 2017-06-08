package com.example.administrator.live.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.live.Adater.CourseistAdater;
import com.example.administrator.live.Adater.TopicListAdater;
import com.example.administrator.live.Adater.TryListAdater;
import com.example.administrator.live.Bean.Banners;
import com.example.administrator.live.Bean.List_Course;
import com.example.administrator.live.Bean.List_Topic;
import com.example.administrator.live.Bean.List_Try;
import com.example.administrator.live.MVPMethods.Presenter.PresenterLayer;
import com.example.administrator.live.MVPMethods.View.Fragmentview;
import com.example.administrator.live.R;
import com.example.administrator.live.Utils.GlideImageLoader;
import com.example.administrator.live.Utils.SharedPreferencesUtils;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/5/15.
 */

public class LearningFragment extends Fragment implements Fragmentview{
    private SharedPreferencesUtils instance;
    private String url;
    private List<String> imgList=new ArrayList<>();
    private Banner br;
    private ListView trylistview;
    private ListView courselistview;
    private ListView topiclistview;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning, null);
        br = (Banner) view.findViewById(R.id.br);
        trylistview = (ListView) view.findViewById(R.id.trylistview);
        courselistview = (ListView) view.findViewById(R.id.courselistview);
        topiclistview = (ListView) view.findViewById(R.id.topiclistview);
        load();
        return view;
    }

    private void load() {
        //得到数据库的工具类对象
        instance = SharedPreferencesUtils.getInstance();
        //得到数据的URL
        url = (String) instance.getData(getActivity(), "URL", "");
        Log.d("zzz","load:"+url);
        PresenterLayer presenterLayer = new PresenterLayer();
        presenterLayer.setFragmentView(this);
        presenterLayer.getBanner(url);
        presenterLayer.getList_Try(url);
        presenterLayer.getList_Course(url);
        presenterLayer.getList_Topic(url);
    }
    @Override
    public Context getActivityContext() {
        return getActivity();
    }
    @Override
    public void setBanner(Banners banner) {
        Banners.DataBean data = banner.getData();
        List<Banners.DataBean.BannerBean> bannerBeen = data.getBanner();
        Log.d("zzz", "setBanner:"+bannerBeen.size());
        for(Banners.DataBean.BannerBean bb:bannerBeen) {
            String image = bb.getImage();
            imgList.add(image);
            Log.d("zzz", image);
        }
        setBanner();
    }

    //设置Banner
    private void setBanner() {
        //设置图片加载器
        br.setImageLoader(new GlideImageLoader());
        //设置图片集合
        br.setImages(imgList);
        //banner设置方法全部调用完毕时最后调用
        br.start();
        //Banner的点击事件
        br.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), "已点击", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void setTryListview(List_Try list_try) {
        List<List_Try.DataBean.TryBean> aTry = list_try.getData().getTryX();
        TryListAdater tryListAdater = new TryListAdater(getActivity());
        tryListAdater.setTryDataList(aTry);
        trylistview.setAdapter(tryListAdater);
        setListViewHeight(trylistview);
        trylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    @Override
    public void setCourseListview(List_Course list_course) {
        List<List_Course.DataBean.CourseBean> courseBeanListr = list_course.getData().getCourse();
        CourseistAdater courseistAdater = new CourseistAdater(getActivity());
        courseistAdater.setCourseDataList(courseBeanListr);
        courselistview.setAdapter(courseistAdater);
        setListViewHeight(courselistview);
    }
    @Override
    public void setCourseListview(List_Topic List_topic) {
        Log.d("zzz", "setCourseListview");
        List<List_Topic.DataBean.TopicBean> topicList = List_topic.getData().getTopic();
        TopicListAdater topicListAdater = new TopicListAdater(getActivity());
        topicListAdater.setTopicDataList(topicList);
        topiclistview.setAdapter(topicListAdater);
        setListViewHeight(topiclistview);
    }

    //设置高度(解决冲突)
    public void setListViewHeight(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = adapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
