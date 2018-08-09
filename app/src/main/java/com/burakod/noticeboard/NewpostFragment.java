package com.burakod.noticeboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewpostFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewpostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewpostFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText mAuthor,mSubject,mMessage;
    DatabaseReference dbRef,dbRefPlus;
    View mView;
    private Button mBtnSend ;
    FirebaseDatabase firebaseDatabase ;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewpostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewpostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewpostFragment newInstance(String param1, String param2) {
        NewpostFragment fragment = new NewpostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;
        init();
    }

    private void init() {

        mAuthor = mView.findViewById(R.id.etName);
        mSubject = mView.findViewById(R.id.etSubject);
        mMessage = mView.findViewById(R.id.etMessage);
        mBtnSend = mView.findViewById(R.id.btnSentMessage);
        mBtnSend.setOnClickListener(this);
        firebaseAuth = firebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance();
        //firebaseUser = firebaseAuth.getCurrentUser();
        //dbRefPlus = FirebaseDatabase.getInstance().getReference();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newpost, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context, "New Post Fragment Attached", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSentMessage){

            String author = mAuthor.getText().toString();
            String subject = mSubject.getText().toString();
            String message = mMessage.getText().toString();


                SendMessage(author,subject,message);



        }
    }

    private void SendMessage(String author, String subject, String message) {


        dbRef = firebaseDatabase.getReference("Notice");
        String key = dbRef.push().getKey();
        dbRefPlus = firebaseDatabase.getReference("Notice/"+key);
        dbRefPlus.setValue(new Notice(author,subject,message));

             //dbRefPlus.child(firebaseUser.getUid()).setValue(new Notice(author,subject,message));  Kullanıcıya özel tek mesaj kullanmak istersen.
        Toast.makeText(getContext(),"Message Sent.",Toast.LENGTH_LONG).show();


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
