package com.example.yck1.cwgl.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yck1.cwgl.R;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SrglFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SrglFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SrglFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SrglFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SrglFragment newInstance(String param1, String param2) {
        SrglFragment fragment = new SrglFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SrglFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_srgl, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText et_srje = (EditText) view.findViewById(R.id.srje);
        final EditText et_srbz = (EditText) view.findViewById(R.id.srbz);
        final TextView tv_srsj = (TextView) view.findViewById(R.id.srsj);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final Date mdate = new java.util.Date();
        String date = sdf.format(mdate);
        tv_srsj.setText(date);
        tv_srsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
                new DatePickerDialog(getActivity(),
                        // 绑定监听器
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                               tv_srsj.setText(year+"/"+(monthOfYear+1)+"/"+dayOfMonth);
                            }
                        }
                        // 设置初始日期
                        , c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
                        .get(Calendar.DAY_OF_MONTH)).show();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                String date = sdf.format(calendarView.getDate());

            }
        });

        Button srcz = (Button) view.findViewById(R.id.cz);
        srcz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_srje.setText("");
                et_srbz.setText("");
            }
        });



        final Spinner spinner_fs = (Spinner) view.findViewById(R.id.spinner_fs);
        String[] srfs = {"现金", "银行转账", "其他"};
        String[] srfl = {"合同款", "债务", "其他"};
        String[] zcfl = {"员工工资", "合同款", "债务", "其他"};
        final ArrayAdapter<String> adapter_srfs = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, srfs);
        spinner_fs.setAdapter(adapter_srfs);
        final Spinner spinner_fl = (Spinner) view.findViewById(R.id.spinner_fl);
        final ArrayAdapter<String> adapter_srfl = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, srfl);
        spinner_fl.setAdapter(adapter_srfl);
        final ArrayAdapter<String> adapter_zcfl = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, zcfl);
        Button srok= (Button) view.findViewById(R.id.srok);
        srok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getFragmentManager().popBackStack();
            }
        });

        final TextView tv_sr = (TextView) view.findViewById(R.id.tv_sr);
        final TextView tv_zc = (TextView) view.findViewById(R.id.tv_zc);
        tv_sr.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tv_sr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_zc.setBackgroundColor(0);
                tv_sr.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                spinner_fl.setAdapter(adapter_srfl);
            }
        });
        tv_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_sr.setBackgroundColor(0);
                tv_zc.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                spinner_fl.setAdapter(adapter_zcfl);
            }
        });

//        getView().setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                if (i == keyEvent.KEYCODE_BACK) {
//                    getFragmentManager().popBackStack();
//                    return true;
//                }else{
//                return false;}
//            }
//        });

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
        public void onFragmentInteraction(Uri uri);
    }

}
