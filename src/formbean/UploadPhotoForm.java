package formbean;


	import java.util.ArrayList;

	import org.mybeans.form.FileProperty;
	import org.mybeans.form.FormBean;

	public class UploadPhotoForm extends FormBean {
		private String dir = "";
		
		public String getDir() {
			return dir;
		}

		public void setDir(String dir) {
			this.dir = dir;
		}


		public ArrayList<String> getValidationErrors() {
			ArrayList<String> errors = new ArrayList<String>();
			
			if (dir == null || dir.length() == 0) {
				errors.add("Invalid Directory");
			}
			
			return errors;
		}
}
