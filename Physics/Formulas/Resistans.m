function res = Resistans(R, p , l ,A)
if R == 0
	res = p * l/A;
elseif p == 0
	res = R / (l/A);
elseif l == 0
	res = R*A/p;
elseif A == 0
	res = p * l/R;
end

