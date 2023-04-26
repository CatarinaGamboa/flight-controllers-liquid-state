package com.liquidjava.flightcontrollers.examples.eval_camera_1;

import io.mavsdk.camera.Camera;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("io.mavsdk.camera.Camera")
@StateSet({"camUninitialized", "camInitialized", "camModeSet", "camVideoMode", "camVideoStreamingMode", "camPhotoIntervalMode"})
public interface CameraRefinements {

	@StateRefinement(to="camUninitialized(this)")
	void Camera();	
	
	@StateRefinement(from="camUninitialized(this)", to="camInitialized(this)")
	void	initialize();	
	
	@StateRefinement(from="!camUninitialized(this)", to="camUninitialized(this)")
	void	dispose();
	
	@StateRefinement(from="camInitialized(this)", to="camModeSet(this)")
	io.reactivex.Completable	setMode​(Camera.Mode mode);
	 
	
	// Video
	@StateRefinement(from="camModeSet(this)", to="camVideoMode(this)")
	io.reactivex.Completable	startVideo();	 
	
	@StateRefinement(from="camVideoMode(this)", to="camModeSet(this)")
	io.reactivex.Completable	stopVideo();



	//Video Streaming
	@StateRefinement(from="camModeSet(this)", to="camVideoStreamingMode(this)")
	io.reactivex.Completable	startVideoStreaming();
	
	@StateRefinement(from="camVideoStreamingMode(this)", to="camModeSet(this)")
	io.reactivex.Completable	stopVideoStreaming();	
	
	
	
	//Photos
	@StateRefinement(from="camModeSet(this)", to="camModeSet(this)")
	io.reactivex.Completable	takePhoto(); 
	
	@StateRefinement(from="camModeSet(this)", to="camModeSet(this)")
	io.reactivex.Completable	selectCamera​(java.lang.Integer cameraId)	; 
	
	//Photo Interval
	@StateRefinement(from="camModeSet(this)", to="camPhotoIntervalMode(this)")
	io.reactivex.Completable	startPhotoInterval​(java.lang.Float intervalS);	 
	
	@StateRefinement(from="camPhotoIntervalMode(this)", to="camModeSet(this)")
	io.reactivex.Completable	stopPhotoInterval(); 

	@StateRefinement(from="camPhotoIntervalMode(this)", to="camPhotoIntervalMode(this)")
	@StateRefinement(from="camModeSet(this)", to="camModeSet(this)")
	io.reactivex.Single<java.util.List<Camera.CaptureInfo>>	listPhotos​(Camera.PhotosRange photosRange);
	
	
	
//	io.reactivex.Completable	formatStorage()	 
//	io.reactivex.Flowable<Camera.CaptureInfo>	getCaptureInfo()	 
//	io.reactivex.Flowable<java.util.List<Camera.Setting>>	getCurrentSettings()	 
//	io.reactivex.Flowable<Camera.Information>	getInformation()	 
//	io.reactivex.Flowable<Camera.Mode>	getMode()	 
//	io.reactivex.Flowable<java.util.List<Camera.SettingOptions>>	getPossibleSettingOptions()	 
//	io.reactivex.Single<Camera.Setting>	getSetting​(Camera.Setting setting)	 
//	io.reactivex.Flowable<Camera.Status>	getStatus()	 
//	io.reactivex.Flowable<Camera.VideoStreamInfo>	getVideoStreamInfo()	 	//		 
//	io.reactivex.Completable	prepare()	 
//	io.reactivex.Completable	selectCamera​(java.lang.Integer cameraId)	 
//	io.reactivex.Completable	setSetting​(Camera.Setting setting)	 
 

}
