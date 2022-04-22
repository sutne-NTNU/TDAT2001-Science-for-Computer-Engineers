function res = ElektriskEffekt(P, U_ab, I, R)
if P == 0
	if U_ab == 0
		res = I^2*R;
	elseif I == 0
		res = U_ab^2/R;
	elseif R == 0
		res = U_ab*I;
	end
elseif U_ab == 0
	if R == 0
		res = P/I;
	else
		res = P*R;
	end
elseif I == 0
	if R == 0
		res = P/U_ab;
	else
		res = sqrt(P/R);
	end
elseif R == 0
	if I == 0
		res = P/I^2;
	else
		res = U_ab/P;
	end
end
end

