package cn.itcast.servlet;

public class WifiDataEntity {
	private int ach_id;//设备id
	private String alco_set;//酒精浓度设置
	private String voice_set;//语音设置
	private String flame_tem_set;//火焰温度设置
	private String intank_tem_set;//槽内温度设置
	private String volume_set;//音量设置
	private String wifi_set;//WiFi设置
	private String leak_detec_set;//泄漏�?测设�?
	private String system_state;//系统状�??
	private String unsafe_types;//不安全类�?
	private String substrate_tem;//基板温度
	private String flame_tem;//基板温度
	private String intank_tem;//槽内温度
	private String alco_concent;//酒精浓度
	private String alco_allowance;//酒精余量
	private String alco_inject;//喷酒精泵
	private String alco_pump;//注酒精泵
	private String fan;//风扇
	private String length;//数据长度
	private String first_level;//�?级液�?
	private String second_level;//二级液位
	private String alco_margin;//酒精余量监测
	private String leak_monitor1;//泄漏监测�?1
	private String leak_monitor2;//泄漏监测�?2
	private String parity_bit;//校验�?
	private String ip_address;//IP地址
	private String addtime;//记录添加时间

	public int getAch_id() {
		return ach_id;
	}

	public void setAch_id(int  ach_id) {
		this.ach_id = ach_id;
	}

	public String getAlco_set() {
		return alco_set;
	}

	public void setAlco_set(String alco_set) {
		this.alco_set = alco_set;
	}

	public String getVoice_set() {
		return voice_set;
	}

	public void setVoice_set(String voice_set) {
		this.voice_set = voice_set;
	}

	public String getFlame_tem_set() {
		return flame_tem_set;
	}

	public void setFlame_tem_set(String flame_tem_set) {
		this.flame_tem_set = flame_tem_set;
	}

	public String getIntank_tem_set() {
		return intank_tem_set;
	}

	public void setIntank_tem_set(String intank_tem_set) {
		this.intank_tem_set = intank_tem_set;
	}

	public String getVolume_set() {
		return volume_set;
	}

	public void setVolume_set(String volume_set) {
		this.volume_set = volume_set;
	}

	public String getWifi_set() {
		return wifi_set;
	}

	public void setWifi_set(String wifi_set) {
		this.wifi_set = wifi_set;
	}

	public String getLeak_detec_set() {
		return leak_detec_set;
	}

	public void setLeak_detec_set(String leak_detec_set) {
		this.leak_detec_set = leak_detec_set;
	}

	public String getSystem_state() {
		return system_state;
	}

	public void setSystem_state(String system_state) {
		this.system_state = system_state;
	}

	public String getUnsafe_types() {
		return unsafe_types;
	}

	public void setUnsafe_types(String unsafe_types) {
		this.unsafe_types = unsafe_types;
	}

	public String getSubstrate_tem() {
		return substrate_tem;
	}

	public void setSubstrate_tem(String substrate_tem) {
		this.substrate_tem = substrate_tem;
	}

	public String getFlame_tem() {
		return flame_tem;
	}

	public void setFlame_tem(String flame_tem) {
		this.flame_tem = flame_tem;
	}

	public String getIntank_tem() {
		return intank_tem;
	}

	public void setIntank_tem(String intank_tem) {
		this.intank_tem = intank_tem;
	}

	public String getAlco_concent() {
		return alco_concent;
	}

	public void setAlco_concent(String alco_concent) {
		this.alco_concent = alco_concent;
	}

	public String getAlco_allowance() {
		return alco_allowance;
	}

	public void setAlco_allowance(String alco_allowance) {
		this.alco_allowance = alco_allowance;
	}

	public String getAlco_pump() {
		return alco_pump;
	}

	public void setAlco_pump(String alco_pump) {
		this.alco_pump = alco_pump;
	}

	public String getAlco_inject() {
		return alco_inject;
	}

	public void setAlco_inject(String alco_inject) {
		this.alco_inject = alco_inject;
	}

	public String getFan() {
		return fan;
	}

	public void setFan(String fan) {
		this.fan = fan;
	}
	
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	public String getFirst_level() {
		return first_level;
	}

	public void setFirst_level(String first_level) {
		this.first_level = first_level;
	}

	public String getSecond_level() {
		return second_level;
	}

	public void setSecond_level(String second_level) {
		this.second_level = second_level;
	}

	public String getAlco_margin() {
		return alco_margin;
	}

	public void setAlco_margin(String alco_margin) {
		this.alco_margin = alco_margin;
	}

	public String getLeak_monitor1() {
		return leak_monitor1;
	}

	public void setLeak_monitor1(String leak_monitor1) {
		this.leak_monitor1 = leak_monitor1;
	}

	public String getLeak_monitor2() {
		return leak_monitor2;
	}

	public void setLeak_monitor2(String leak_monitor2) {
		this.leak_monitor2 = leak_monitor2;
	}

	public String getParity_bit() {
		return parity_bit;
	}

	public void setParity_bit(String parity_bit) {
		this.parity_bit = parity_bit;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	@Override
	public String toString() {
		return "WifiDataEntity [ach_id=" + ach_id + ", alco_set=" + alco_set
				+ ", voice_set=" + voice_set + ", flame_tem_set=" + flame_tem_set
				+ ", intank_tem_set=" + intank_tem_set + ", volume_set=" + volume_set
				+ ", wifi_set=" + wifi_set + ", leak_detec_set=" + leak_detec_set
				+ ", system_state=" + system_state + ", unsafe_types=" + unsafe_types 
				+ ", substrate_tem=" + substrate_tem + ", flame_tem=" + flame_tem 
				+ ", intank_tem=" + intank_tem + ", alco_concent=" + alco_concent 
				+ ", alco_allowance=" + alco_allowance + ", alco_inject=" + alco_inject 
				+ ", alco_pump=" + alco_pump + ", fan=" + fan 
				+ ", first_level=" + first_level + ", second_level=" + second_level 
				+ ", alco_margin=" + alco_margin + ", leak_monitor1=" + leak_monitor1 
				+ ", leak_monitor2=" + leak_monitor2 + ", parity_bit=" + parity_bit 
				+ ", ip_address=" + ip_address + ", addtime=" + addtime + "]";
	}

}
