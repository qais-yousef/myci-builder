def call() {
	sh """
		out=\$(ls android-kernel/out)
		tar cJf \$out.tar.xz android-kernel/out/\$out/dist
	"""
}
