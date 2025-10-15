package com.example.demo.adaptercontroller;

import org.springframework.stereotype.Service;



@Service
public class ControllerAdapterImpl implements ControllerAdapterService, CommonControllerService{

	@Override
	public String addNode() {
		// TODO Auto-generated method stub
		return "addNode";
	}

	@Override
	public String removeNode() {
		// TODO Auto-generated method stub
		return "removeNode";
	}

	@Override
	public String superviseNode() {
		// TODO Auto-generated method stub
		return "SuperviseNode";
	}

}
