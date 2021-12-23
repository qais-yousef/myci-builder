def call(branch, num_parallel_jobs) {
	sh """
		mkdir -p aosp

		pushd aosp

		repo init -u https://android.googlesource.com/platform/manifest -b ${branch}

		repo sync -cdq -j ${num_parallel_jobs}

		popd
	"""
}
