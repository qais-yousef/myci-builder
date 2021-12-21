def call(config, uclamp_min, uclamp_max, num_parallel_jobs) {
	sh """
		# ARCH and CROSS_COMPILE are set by job params and exported
		# automatically

		pushd linux
		make "${config}"
		uclampset -m ${uclamp_min} -M ${uclamp_max} \
			make -j ${num_parallel_jobs}
		popd
	"""
}
