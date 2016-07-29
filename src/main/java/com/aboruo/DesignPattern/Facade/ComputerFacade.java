package com.aboruo.DesignPattern.Facade;
/**
 * 类名称：ComputerFacade
 * 类描述：计算机门面类
 * @author aboruo
 * @date 2016年7月29日 下午3:00:20
 */
public class ComputerFacade {
	private CPU cpu;
	private MemeryCache memeryCache;
	private Disk disk;
	public ComputerFacade(){
		this.cpu =new CPU();
		this.memeryCache = new MemeryCache();
		this.disk = new Disk();
	}
	public void startUp(){
		cpu.run();
		memeryCache.provideMemeryStorage();
		memeryCache.needDiskStorage();
		disk.provideDiskStorage();
	}
	public int needMemeryStorage(){
		return this.memeryCache.provideMemeryStorage();
	}
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public MemeryCache getMemeryCache() {
		return memeryCache;
	}
	public void setMemeryCache(MemeryCache memeryCache) {
		this.memeryCache = memeryCache;
	}
	public Disk getDisk() {
		return disk;
	}
	public void setDisk(Disk disk) {
		this.disk = disk;
	}
}
