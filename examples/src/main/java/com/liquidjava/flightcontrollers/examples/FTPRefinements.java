package com.liquidjava.flightcontrollers.examples;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@StateSet({"ftpUnconnected", "ftpInitialized","ftpIdSet","ftpRootDirectorySet","ftpIdRootDirectorySet"})
@ExternalRefinementsFor("io.mavsdk.ftp.Ftp")
public interface FTPRefinements {
	
	@StateRefinement(to="ftpUnconnected(this)")
	void Ftp();

	@StateRefinement(from="!ftpUnconnected(this)", to="ftpUnconnected(this)")
	void	dispose()	;
	
	@StateRefinement(from="ftpUnconnected(this)", to="ftpInitialized(this)")
	void	initialize()	;
	
	@StateRefinement(from="ftpInitialized(this)", to="ftpIdSet(this)")
	@StateRefinement(from="ftpIdSet(this)", to="ftpIdSet(this)")
	@StateRefinement(from="ftpIdRootDirectorySet(this)", to="ftpIdRootDirectorySet(this)")
	io.reactivex.Completable	setTargetCompid​(java.lang.Integer compid)	 ;

	@StateRefinement(from="ftpIdSet(this)", to="ftpInitialized(this)")
	@StateRefinement(from="ftpRootDirectorySet(this)", to="ftpInitialized(this)")
	@StateRefinement(from="ftpIdRootDirectorySet(this)", to="ftpInitialized(this)")
	io.reactivex.Completable	reset()	 ;
	
	@StateRefinement(from="ftpIdSet(this)", to="ftpIdSet(this)")
	@StateRefinement(from="ftpIdRootDirectorySet(this)", to="ftpIdRootDirectorySet(this)")
	@StateRefinement(from="ftpIdRootDirectorySet(this)", to="ftpIdRootDirectorySet(this)")
	io.reactivex.Single<java.lang.Integer>	getOurCompid()	 ;
	
	
	@StateRefinement(from="ftpInitialized(this)", to="ftpRootDirectorySet(this)")
	@StateRefinement(from="ftpIdSet(this)", to="ftpIdRootDirectorySet(this)")
	@StateRefinement(from="ftpIdRootDirectorySet(this)", to="ftpIdRootDirectorySet(this)")
	io.reactivex.Completable	setRootDirectory​(java.lang.String rootDir)	 ;
		
}
