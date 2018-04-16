//function $() {
//	var elements = new Array();
//	for (var i = 0; i < arguments.length; i++) {
//		var element = arguments[i];
//		if (typeof element == 'string')
//			element = document.getElementById(element);
//		if (arguments.length == 1)
//			return element;
//		elements.push(element);
//	}
//	return elements;
//}

IdCardOp = function(obj) {
	this.obj = obj;
}

IdCardOp.prototype = {
	Open : function() {
		for (i = 1; i < 9; i++) {
			if (this.obj.OpenComm(i) == 1)
				return true;
		}
		for (i = 1001; i <= 1009; i++) {
			if (this.obj.OpenComm(i) == 1) {
				return true;
			}
		}
		return false;
	},
	Close : function() {
		this.obj.EndComm();
	},
	ReadInfo : function() {
		var rt = new Object();
		if (this.obj.Authen() == 1) {
			if (this.obj.ReadCardPath("", 1)) {
				rt.Name = this.obj.sName;
				rt.Sex = this.obj.sSex;
				rt.Nation = this.obj.sNation;
				rt.BornDate = this.obj.sBornDate;
				rt.Address = this.obj.sAddress;
				rt.IDNo = this.obj.sIDNo;
				rt.SignGov = this.obj.sSignGov;
				rt.StartDate = this.obj.sStartDate;
				rt.EndDate = this.obj.sEndDate;
				rt.PhotoBuffer = this.obj.PhotoBuffer;
			} else
			throw "�豸�����쳣��";
		} else
		throw "��ſ�Ƭ";

		
		this.Close();

		return rt;
	}
}

/* 

 * 读取卡内容
 * 返回值为证件对象
 * 属性内容为：
 * 姓名 Name
 * 性别 Sex 1-男 2-女
 * 国家Nation
 * 出生日期BornDate
 * 地址Address
 * 身份证号IDNo
 * 签发机关SignGov
 * 有效期开始日期StartDate
 * 有效期结束日期EndDate
 * 照片文件PhotoBuffer
 */
/*
 * /* <object id="OCX" codebase="Termb.cab#version=1,0,0,1"
 * classid="clsid:18EE8930-6993-4ADA-B8BB-02BA5820AC94"></object>
 */
function initial(stateShow) {
	var op = new IdCardOp(document.getElementById("OCX"));
	var showInfoSpan = document.getElementById(stateShow);
	if (op.Open()) {
		showInfoSpan.innerHTML = "设备已打开！";
		op.Close();
		return 0;
	} else {
		showInfoSpan.innerHTML = "设备打开失败，请检查设备连接情况！!";
		return -1;
	}
}

function readIdCard(runSign, stateShow) {
	try {
		var reader;
		var op = new IdCardOp(document.getElementById("OCX"));
		var showInfoSpan = document.getElementById("showInfo");
		op.Open();
		reader = op.ReadInfo();
		op.Close();
		return reader;
	} catch (e) {
		showInfoSpan.innerHTML = "读卡器提示:" + e;
		op.Close();
		return -1;
	}
	// op.Close();
}