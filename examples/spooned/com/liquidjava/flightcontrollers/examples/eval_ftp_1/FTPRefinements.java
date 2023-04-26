package com.liquidjava.flightcontrollers.examples.eval_ftp_1;


@liquidjava.specification.StateSet({ "ftpUnconnected", "ftpInitialized", "ftpIdSet", "ftpRootDirectorySet", "ftpIdRootDirectorySet" })
@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.ftp.Ftp")
public interface FTPRefinements {
    @liquidjava.specification.StateRefinement(to = "ftpUnconnected(this)")
    void Ftp();

    @liquidjava.specification.StateRefinement(from = "!ftpUnconnected(this)", to = "ftpUnconnected(this)")
    void dispose();

    @liquidjava.specification.StateRefinement(from = "ftpUnconnected(this)", to = "ftpInitialized(this)")
    void initialize();

    @liquidjava.specification.StateRefinement(from = "ftpInitialized(this)", to = "ftpIdSet(this)")
    @liquidjava.specification.StateRefinement(from = "ftpIdSet(this)", to = "ftpIdSet(this)")
    @liquidjava.specification.StateRefinement(from = "ftpIdRootDirectorySet(this)", to = "ftpIdRootDirectorySet(this)")
    io.reactivex.Completable setTargetCompid​(java.lang.Integer compid);

    @liquidjava.specification.StateRefinement(from = "ftpIdSet(this)", to = "ftpInitialized(this)")
    @liquidjava.specification.StateRefinement(from = "ftpRootDirectorySet(this)", to = "ftpInitialized(this)")
    @liquidjava.specification.StateRefinement(from = "ftpIdRootDirectorySet(this)", to = "ftpInitialized(this)")
    io.reactivex.Completable reset();

    @liquidjava.specification.StateRefinement(from = "ftpIdSet(this)", to = "ftpIdSet(this)")
    @liquidjava.specification.StateRefinement(from = "ftpIdRootDirectorySet(this)", to = "ftpIdRootDirectorySet(this)")
    @liquidjava.specification.StateRefinement(from = "ftpIdRootDirectorySet(this)", to = "ftpIdRootDirectorySet(this)")
    io.reactivex.Single<java.lang.Integer> getOurCompid();

    @liquidjava.specification.StateRefinement(from = "ftpInitialized(this)", to = "ftpRootDirectorySet(this)")
    @liquidjava.specification.StateRefinement(from = "ftpIdSet(this)", to = "ftpIdRootDirectorySet(this)")
    @liquidjava.specification.StateRefinement(from = "ftpIdRootDirectorySet(this)", to = "ftpIdRootDirectorySet(this)")
    io.reactivex.Completable setRootDirectory​(java.lang.String rootDir);
}

