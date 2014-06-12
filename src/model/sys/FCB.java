package model.sys;

import java.io.Serializable;
import java.util.Date;

import model.sys.Config.FILE_TYPE;

/**
 * 
 * @author Tom Hu
 * 
 */
public class FCB implements Serializable {
	
	private static final long serialVersionUID = -5262771405010721496L;
	
	public String filename; // 文件名
	public FILE_TYPE type; // FILE 或 DORECTORY
	public String address; // 文件地址
	public Date createdDate;
	public Date updatedDate;
	public FCB fatherFCB; //指向上一级FCB
	public int size; // 当前文件控制块所对应的数据区块个数
	public int[] dataBlockArray; // 存放数据块的id

	// Constructor
	public FCB(String filename, FCB fatherFCB, FILE_TYPE type, int size) {
		this.filename = filename;
		this.fatherFCB = fatherFCB;
		this.type = type;
		this.size = size;
		this.createdDate = new Date();
		this.updatedDate = (Date) this.createdDate.clone();
		
		this.dataBlockArray = new int[Config.FILE_MAX_BLOCKS];
	}
}
