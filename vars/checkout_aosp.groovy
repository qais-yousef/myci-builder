def call(branch, num_parallel_jobs) {
	sh """
		mkdir -p aosp

		pushd aosp

		if [ ! -e .${branch} ]; then

			repo init -u https://android.googlesource.com/platform/manifest -b ${branch}
			repo sync -cd -j ${num_parallel_jobs}
			touch .${branch}

		fi

		popd
	"""
}
