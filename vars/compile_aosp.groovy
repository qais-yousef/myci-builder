def call(target, num_parallel_jobs) {
	sh """
		pushd aosp

		source build/envsetup.sh
		lunch ${target}
		m -j ${num_parallel_jobs}

		popd
	"""
}
