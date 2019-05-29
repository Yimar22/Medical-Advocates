package threads;

import ui.DiagnosisScreenController;

public class DialogsThread extends Thread{

	private DiagnosisScreenController dsc;
	
	public DialogsThread(DiagnosisScreenController dsc) {
		this.dsc=dsc;
	}
	
	public void run() {
		DialogsThread dialog=new DialogsThread(dsc);
		dsc.dialogs();
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}
