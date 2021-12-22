def call(branch, num_parallel_jobs) {
	sh """
		mkdir -p aosp

		pushd aosp

		repo init -u https://android.googlesource.com/platform/manifest \
			-b ${branch} --partial-clone --clone-filter=blob:limit=10M

		repo sync -v -cd -j ${num_parallel_jobs}

		popd
	"""
}
