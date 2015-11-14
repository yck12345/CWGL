package com.example.yck1.cwgl.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.yck1.cwgl.Activity.dummy.DummyContent;
import com.example.yck1.cwgl.File.FileIO;
import com.example.yck1.cwgl.R;
import com.example.yck1.cwgl.User.Sr;
import com.example.yck1.cwgl.User.User;
import com.example.yck1.cwgl.User.Zc;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class SzckFragment extends Fragment implements AbsListView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private ListView mListView;


    User user;
    List<Map<String, Object>> listItems;
    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private SimpleAdapter mAdapter;

    // TODO: Rename and change types of parameters
    public static SzckFragment newInstance(String param1, String param2) {
        SzckFragment fragment = new SzckFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SzckFragment() {
    }

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        FileIO fileIO = new FileIO();
        String s = fileIO.read("sr.json");
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(User.class,new UserDeserializer());
//        gsonBuilder.registerTypeAdapter(Sr.class, new SrDeserializer());
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(s).getAsJsonArray();
        Gson gson = new Gson();
        int arraynumber = jsonArray.size();
        Sr[] sr = new Sr[arraynumber];
        for (int i = 0; i <jsonArray.size() ; i++) {
            sr[i]= gson.fromJson(jsonArray.get(i),Sr.class);
        }
        int[] count = new int[arraynumber];
        String[] time = new String[arraynumber];
        String[] description = new String[arraynumber];
        String[] fs = new String[arraynumber];
        String[] fl = new String[arraynumber];
        FileIO file =new FileIO();
        String string = file.read("zc.json");
        JsonArray json1 = jsonParser.parse(string).getAsJsonArray();
        int arraynumber1 = json1.size();
        Zc[] zc = new Zc[arraynumber1];
        for (int i = 0; i <json1.size() ; i++) {
            zc[i] = gson.fromJson(json1.get(i),Zc.class);
        }
        for (int i = 0; i < jsonArray.size(); i++) {
            count[i] = sr[i].getCount();
            time[i] = sr[i].getTime();
            description[i] = sr[i].getDescription();
            fs[i] = sr[i].getFs();
            fl[i] = sr[i].getFl();
        }
        int[] count1 = new int[arraynumber1];
        String[] time1 = new String[arraynumber1];
        String[] description1 = new String[arraynumber1];
        String[] fs1 = new String[arraynumber1];
        String[] fl1 = new String[arraynumber1];
        for (int i = 1; i <json1.size() ; i++) {
            count1[i] = zc[i].getCount();
            time1[i] = zc[i].getTime();
            description1[i] = zc[i].getDescription();
            fs1[i] = zc[i].getFs();
            fl1[i] = zc[i].getFl();
        }
         listItems = new ArrayList<Map<String, Object>>();
        for (int i = 1; i < jsonArray.size(); i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("time", time[i]);
            listItem.put("count", count[i]);
            listItem.put("description", description[i]);
            listItem.put("fs", fs[i]);
            listItem.put("fl", fl[i]);
            listItems.add(listItem);
        }

        mAdapter = new SimpleAdapter(getActivity(), listItems, R.layout.list_item, new String[]{"time", "count",  "fs", "fl","description"},
                new int[]{R.id.tv_time,R.id.tv_count,R.id.tv_description,R.id.tv_list_fs,R.id.tv_list_fl});

//        //TODO: Change Adapter to display your content
//        mAdapter = new ArrayAdapter<DummyContent.DummyItem>(getActivity(),
//                android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.ITEMS);
    }

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
            View view = inflater.inflate(R.layout.fragment_item, container, false);

            // Set the adapter
            mListView = (ListView) view.findViewById(R.id.list);
            mListView.setAdapter(mAdapter);

            // Set OnItemClickListener so we can be notified on item clicks
            mListView.setOnItemClickListener(this);

            return view;
        }

        @Override
        public void onAttach (Activity activity){
            super.onAttach(activity);
            try {
                mListener = (OnFragmentInteractionListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach () {
            super.onDetach();
            mListener = null;
        }

        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onFragmentInteraction(listItems.get(position).toString());
            }
        }

        /**
         * The default content for this Fragment has a TextView that is shown when
         * the list is empty. If you would like to change the text, call this method
         * to supply the text it should use.
         */

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

}
